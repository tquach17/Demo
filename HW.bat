@echo off
rem dir
rem dir tempconvtr.*

if exist tempconvtr.class (
		echo Deleting tempconvtr.class ...
		del tempconvtr.class
		)

javac tempconvtr.java

if not exist tempconvtr.class (
	echo Complition Failed ... tempconvtr.class not created
) else (
	echo running tempconvtr
	echo Executing Test case 1 -- inputs K C -10
	echo K C -10.00|java tempconvtr
	echo Executing Test case 4 -- inputs C K -380
	echo C K -380.00|java tempconvtr
	echo Executing Test case 7 -- inputs T H 77
	echo T H 77.00|java tempconvtr
	echo Executing Test case 8 -- inputs h w 67
	echo h w 67.00|java tempconvtr
	echo Executing Test case 11 -- inputs c f 25
	echo c f 25.00|java tempconvtr
	echo Executing Test case 12 -- inputs k c 255
	echo k c 255.00|java tempconvtr
	echo Executing Test case 9 -- inputs A B 55
	echo A B 55.00|java tempconvtr
	echo Executing Test case 10 -- inputs Z Y 22
	echo Z Y 22.00|java tempconvtr
	echo Executing Test case 19 -- inputs K F 455
	echo K F 455.00|java tempconvtr
	echo Executing Test case 20 -- inputs K C 32
	echo K C 32.00|java tempconvtr
)


@echo on