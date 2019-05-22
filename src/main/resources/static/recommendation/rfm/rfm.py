# -*- coding: utf-8 -*-

import pandas as pd
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
from sklearn.manifold import TSNE
import pymysql
from sqlalchemy import create_engine

# --------------数据准备-----------------
outputfile = 'data_type.csv'

k = 2
iteration = 500

# db
db = pymysql.connect("localhost", "root", "", "rental")
data = pd.read_sql("select * from rtv_rfm_data",db,index_col='user_id')
data_zs = (data - data.mean()) / data.std()  # 标准化，消除度量单位的干扰
db.close()

# ---------------聚类分析-----------------
model = KMeans(n_clusters=k, init='k-means++', max_iter=iteration)  # 分为k类，最多迭代500次
model.fit(data_zs)

# ----------------打印结果----------------

# 统计各类别数目
r1 = pd.Series(model.labels_).value_counts()
r2 = pd.DataFrame(model.cluster_centers_)
r = pd.concat([r2, r1], axis=1)
r.columns = list(data.columns) + [u'聚类数量']
print(r)

# 样本到对应聚类中心的距离平方和
print(model.inertia_)

# 各样本对应聚类
r3 = pd.Series(model.labels_, index=data.index)
r = pd.concat([data, r3], axis=1)
r.columns = list(data.columns) + [u'consumpation_type']
r.to_csv(outputfile)

# db save
engine = create_engine("mysql+pymysql://{}:{}@{}/{}?charset={}".format('root', '', '127.0.0.1:3306', 'rental','utf8'))
con = engine.connect()
df = pd.DataFrame(r)
df.insert(0,'user_id',data.index.values)
df.to_sql("rt_rfm_user",con,if_exists='replace',index=False)
con.close()

# ----------------画图比较----------------
plt.rcParams['font.sans-serif'] = ['SimHei']
plt.rcParams['axes.unicode_minus'] = False

for i in range(k):
    cls = data[r[u'consumpation_type'] == i]
    if cls.size>3:
        cls.plot(kind='kde', subplots=True, sharex=False)
        plt.suptitle('consumpation_type=%d; 样本数=%d' % (i, r1[i]))

plt.legend()
plt.show()

# -----------聚类降维可视化-----------
tsne = TSNE()
tsne.fit_transform(data_zs)  # 进行数据降维
print(type(tsne))
tsne = pd.DataFrame(tsne.embedding_, index=data_zs.index)  # 转换数据格式

for j in range(k):
    d = tsne[r[u'consumpation_type'] == j]
    plt.plot(d[0], d[1], '.')

plt.show()
