from aip import AipNlp
APP_ID = '16284086'
API_KEY = 'wqkohbl8dG6OY2uGNHtP8VaZ'
SECRET_KEY = 'Dd7elqS6IyPrw3Z1dN4GwCfDvfxoG7d4'
client = AipNlp(APP_ID, API_KEY, SECRET_KEY)

res = client.keyword("iphone手机出现“白苹果”原因及解决办法，用苹果手机的可以看下","如果下面的方法还是没有解决你的问题建议来我们门店看下成都市锦江区红星路三段99号银石广场24层01室。")

print(res)