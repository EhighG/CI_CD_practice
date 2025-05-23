#!/usr/bin/env bash
REPOSITORY=/home/ubuntu/CI_CD_practice
cd $REPOSITORY

echo "> Build 파일 복사"
cp ./build/libs/*.jar $REPOSITORY/

echo "현재 구동중인 애플리케이션 pid 확인"
CURRENT_PID=${pgrep -fl CI_CD_practice}
echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]
then
  echo "> 종료 대상 프로세스 없음"
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo ">$JAR_NAME에 실행 권한 추가"
chmod +x $JAR_NAME

echo ">$JAR_NAME 실행"

nohup java -jar $JAR_NAME > /dev/null 2> /dev/null < /dev/null &