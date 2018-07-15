@echo off
set current_path="%cd%"
cd %current_path%
call mvn mybatis-generator:generate
pause