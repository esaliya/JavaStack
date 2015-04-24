#!/bin/bash
cp=$HOME/.m2/repository/com/google/guava/guava/15.0/guava-15.0.jar:$HOME/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:$HOME/.m2/repository/ompi/ompijavabinding/1.8.1/ompijavabinding-1.8.1.jar:$HOME/sali/git/github/esaliya/JavaStack/kmeans/target/kmeans-1.0-SNAPSHOT.jar


n=1000000
d=3
k=100
java -cp $cp org.saliya.ompi.kmeans.DataGenerator -n $n -d $d -k $k -o $HOME/sali/git/github/esaliya/JavaStack/kmeans -b true -t false
