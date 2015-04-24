#!/bin/bash
cp=$HOME/.m2/repository/com/google/guava/guava/15.0/guava-15.0.jar:$HOME/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:$HOME/.m2/repository/ompi/ompijavabinding/1.8.1/ompijavabinding-1.8.1.jar:$HOME/sali/git/github/esaliya/JavaStack/kmeans/target/kmeans-1.0-SNAPSHOT.jar

wd=$HOME/sali/git/github/esaliya/JavaStack/kmeans
c=$wd/centers.bin
p=$wd/points.bin
n=1000000
d=3
k=100
m=100
t=0.00001
b=true


np=$1
mpirun --report-bindings --map-by socket:PE=1 -np $np java -cp $cp org.saliya.ompi.kmeans.Program -n $n -d $d -k $k -t $t -c $c -p $p -m $m -b $b -o out.txt

