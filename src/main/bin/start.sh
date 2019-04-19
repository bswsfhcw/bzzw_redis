ps -ef|grep bzzw-0.0.1-SNAPSHOT.jar |grep -v grep|awk '{print "kill -9 "$2}' | sh
java  -Dloader.path=.,../conf,../lib -jar ../bzzw-0.0.1-SNAPSHOT.jar