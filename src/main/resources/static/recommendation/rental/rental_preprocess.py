# -*- coding: utf-8 -*-
# Origin resource from MovieLens: http://grouplens.org/datasets/movielens/1m
import pandas as pd
import pymysql


class Channel:
    """
    simple processing for *.dat to *.csv
    """

    def __init__(self):
        self.origin_path = 'rental/{}'
        self.user_data = None
        self.car_data = None
        self.rating_data = None

    def _link_db(self):
        db = pymysql.connect("localhost", "root", "", "rental")
        cursor = db.cursor()
        # user
        self.user_data = pd.read_sql("select * from rtv_lfm_user",db)
        # car
        cursor.execute("select * from rtv_lfm_car")
        self.car_data = cursor.fetchall()
        # rating
        cursor.execute("select * from rtv_lfm_rating")
        self.rating_data = cursor.fetchall()
        cursor.close()
        db.close()

    def process(self):
        self._link_db()
        print('Process user data...')
        self._process_user_data()
        print('Process car data...')
        self._process_cars_date()
        print('Process rating data...')
        self._process_rating_data()
        print('End.')

    def _process_user_data(self):
        self.user_data.to_csv(self.origin_path.format('users.csv'), index=False)

    def _process_rating_data(self, file='ratings.dat'):
        f = pd.read_table(self.origin_path.format(file), sep='::', engine='python',
                          names=['UserID', 'MovieID', 'Rating', 'Timestamp'])
        f.to_csv(self.origin_path.format('ratings.csv'), index=False)

    def _process_cars_date(self, file='movies.dat'):
        f = pd.read_table(self.origin_path.format(file), sep='::', engine='python',
                          names=['MovieID', 'Title', 'Genres'])
        f.to_csv(self.origin_path.format('movies.csv'), index=False)


if __name__ == '__main__':
    Channel().process()
