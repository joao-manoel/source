@echo off
echo Compiling...
"C:\Program Files\Java\jdk-17\bin\javac.exe" -d bin -cp lib/*; -sourcepath src src/com/rs/*.java
@echo Finished.
pause