@echo off

echo Buenas buenas, este script nomas crea carpetas con nombres consecutivos.
echo Es mas por vagancia. Atte Len.

setlocal enabledelayedexpansion

set /p nombre="Ingresa el nombre base para las carpetas: "
set /p cantidad="Ingresa la cantidad de carpetas que deseas crear: "

set /a inicio=1

for /l %%i in (%inicio%, 1, %cantidad%) do (
    md "%nombre% %%i"
)

echo.
echo Che, creaste %cantidad% de carpetas con el nombre base "%nombre%" seguido de numeros consecutivos.
pause
