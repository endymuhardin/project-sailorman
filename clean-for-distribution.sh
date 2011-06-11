#!/bin/sh

rm -rf .git RemoteSystemTempFiles Servers
rm .gitignore
find . -name \.classpath | xargs rm 
find . -name \.project | xargs rm 
find . -name \.springBeans | xargs rm 
find . -name \.settings | xargs rm -r
find . -name \.metadata | xargs rm -r 
