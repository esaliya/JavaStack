#!/bin/bash
#cp=/home/saliya/.m2/repository/com/google/guava/guava/15.0/guava-15.0.jar:/home/saliya/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/home/saliya/.m2/repository/ompi/ompijavabinding/1.8.1/ompijavabinding-1.8.1.jar:/home/saliya/sali/git/github/esaliya/JavaStack/kmeans/target/kmeans-1.0-SNAPSHOT.jar

cp=/home/saliya/.m2/repository/com/google/guava/guava/18.0/guava-18.0.jar:/home/saliya/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/home/saliya/.m2/repository/ompi/ompijavabinding/1.8.4/ompijavabinding-1.8.4.jar:/home/saliya/sali/git/github/esaliya/JavaStack/kmeans/target/kmeans-1.0-SNAPSHOT.jar

n=1000000
d=3
k=100
java -cp $cp org.saliya.ompi.kmeans.DataGenerator -n $n -d $d -k $k -o /home/saliya/sali/git/github/esaliya/JavaStack/kmeans -b true -t true
