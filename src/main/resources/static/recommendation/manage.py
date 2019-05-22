# -*- coding: utf-8 -*-
import sys
from preprocess import Channel
from workflow.cf_workflow import run as user_cf
from workflow.lfm_workflow import run as lfm
from workflow.lfm_workflow import predict as lfm_predict
from workflow.prank_workflow import run as prank
import pandas as pd
import pymysql
from sqlalchemy import create_engine

def manage():
    #arg = sys.argv[1]
    arg = "prank"
    if arg == 'preprocess':
        Channel().process()
    elif arg == 'cf':
        user_cf()
    elif arg == 'lfm':
        lfm()
    elif arg == 'prank':
        prank()
    else:
        print('Args must in ["preprocess", "cf", "lfm"，"prank"].')
    sys.exit()

def predict():
    arg = sys.argv[1]
    cars = lfm_predict(int(arg))

    # db
    db = pymysql.connect("localhost", "root", "", "rental")
    cursor = db.cursor()
    try:
        cursor.execute("DELETE FROM rt_lfm_recommendation WHERE rt_lfm_recommendation.user_id = "+str(arg))
        db.commit()
    except:
        db.rollback()
    cursor.close()
    db.close()

    engine = create_engine(
        "mysql+pymysql://{}:{}@{}/{}?charset={}".format('root', '', '127.0.0.1:3306', 'rental', 'utf8'))
    con = engine.connect()
    df = pd.DataFrame(cars)
    df.insert(0, 'user_id', arg)
    df.columns = ['user_id', 'car_id', 'rate']
    df.to_sql("rt_lfm_recommendation", con, if_exists='append', index=False)
    con.close()

    return cars is not None


if __name__ == '__main__':
    predict()
