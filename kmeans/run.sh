#!/bin/bash
cp=/home/saliya/.m2/repository/com/google/guava/guava/15.0/guava-15.0.jar:/home/saliya/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/home/saliya/.m2/repository/ompi/ompijavabinding/1.8.1/ompijavabinding-1.8.1.jar:/home/saliya/sali/git/github/esaliya/JavaStack/kmeans/target/kmeans-1.0-SNAPSHOT.jar

wd=/home/saliya/sali/git/github/esaliya/JavaStack/kmeans
n=100000
d=1000
k=100
t=0.00001

np=4
mpirun -np $np java -cp $cp org.saliya.ompi.kmeans.Program -n $n -d $d -k $k -t $t -o $wd/out.txt -c $wd/centers.bin -p $wd/points.bin 
