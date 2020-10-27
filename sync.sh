#! /bin/bash

if [ $# -eq 0 ]
then 
	msg='Commit Work'
else 
	msg='Solve Problem '$1
fi

#git add --all
git commit -m "$msg"
git pull

