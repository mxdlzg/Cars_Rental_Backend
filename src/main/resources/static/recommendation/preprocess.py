# -*- coding: utf-8 -*-
# Origin resource from MovieLens: http://grouplens.org/datasets/movielens/1m
import pandas as pd
import pymysql


class Channel:
    """
    simple processing for *.dat to *.csv
    """

    def __init__(self):
        self.origin_path = 'data/{}'
        self.user_data = None
        self.car_data = None
        self.rating_data = None

    def _link_db(self):
        db = pymysql.connect("localhost", "root", "", "rental")
        cursor = db.cursor()
        # user
        self.user_data = pd.read_sql("select * from rtv_lfm_user",db)
        # car
        self.car_data = pd.read_sql("select * from rtv_lfm_car",db)
        # rating
        self.rating_data = pd.read_sql("select * from rtv_lfm_rating",db)
        cursor.close()
        db.close()

    def process(self):
        self._link_db()
        print('Process user data...')
        self._process_user_data()
        print('Process movies data...')
        self._process_movies_date()
        print('Process rating data...')
        self._process_rating_data()
        print('End.')

    def _process_user_data(self, file='users.dat'):
        self.user_data.to_csv(self.origin_path.format('users.csv'), index=False)

    def _process_rating_data(self, file='ratings.dat'):
        self.rating_data.to_csv(self.origin_path.format('ratings.csv'), index=False)

    def _process_movies_date(self, file='movies.dat'):
        self.car_data.to_csv(self.origin_path.format('movies.csv'), index=False)


if __name__ == '__main__':
    Channel().process()
