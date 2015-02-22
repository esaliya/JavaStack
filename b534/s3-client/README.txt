S3Console
---------

A console to work with Amazon S3.

Note. You need to place your Amazon Access Key and Secret Key in the conf/credentials.txt
      prior to running the bin/run.bat. Place these in two lines where first line should
      be the Access Key and second line should be Secret Key.


Commands
--------

ls                  - list local files
pwd                 - print local working directory
cd path             - change local working directory

als                 - list amazon buckets

get ap lp           - download resource from Amazon S3 path, ap to local path, lp.
                      This version supports only full path names.

                      E.g. get X/y/z/foo.txt C:/users/some-folder

                           where X is the bucket name, y and z are logical folder
                           names (i.e. parts of the key of the foo.txt)

put lp ap           - upload a resource from local path, lp to Amazon S3 path, ap.
                      This version supports only full path names.

                      E.g. put C:/users/some-folder/foo.txt X/y/z

                           where X is the bucket name, y and z are logical folder
                           names (i.e. parts of the key to the foo.txt eventually)
