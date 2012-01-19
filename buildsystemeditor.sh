#!/bin/sh
#===========================================================================
# update:
# cerate:Sep/11/2008
# 
# このシェルスクリプトは RTSystemEditor をビルドします。
#     （以降、"Update"毎に上記に日付、名前、変更内容を記述する）
# このシェルスクリプトは RTSystemEditor をビルドします。
# 環境
#  以下にビルドに必要な環境とインストール方法を簡単に示します。
#   Eclipse SDK
#   ant
#   ant4eclipse
#   jdk
# 
# 環境変数
#  ビルドに必要な環境変数を以下に示します。
#   ECLIPSE_HOME   Eclipse SDK 3.2.x の実行ファイルがあるディレクトリを指定�
#   ECLIPSE33_HOME Eclipse SDK 3.3.x の実行ファイルがあるディレクトリを指定�
#   ANT_HOME       ant のディレクトリを指定します。
#   JAVA_HOME      jdkのディレクトリを指定します。
#
#===========================================================================
#
#

#---------------------------------------------------------------------------
#---------------------------------------------------------------------------
set DUMMY=$ANT_HOME
export ANT_HOME=$ECLIPSE_HOME/plugins/org.apache.ant_1.6.5/
#---------------------------------------------------------------------------
#
#---------------------------------------------------------------------------
declare -a build_tbl=(	\
	"jp.go.aist.rtm.toolscommon"	\
	"jp.go.aist.rtm.toolscommon.nl1"	\
	"jp.go.aist.rtm.toolscommon.profiles"	\
	"jp.go.aist.rtm.toolscommon.profiles.nl1"	\
	"jp.go.aist.rtm.repositoryView"	\
	"jp.go.aist.rtm.repositoryView.nl1"	\
	"jp.go.aist.rtm.nameserviceview"	\
	"jp.go.aist.rtm.nameserviceview.nl1"	\
	"jp.go.aist.rtm.systemeditor"	\
	"jp.go.aist.rtm.systemeditor.nl1"	\
)


declare	-i num
declare -i ic
num=${#build_tbl[@]}

ic=0
while [ $ic -lt $num ]
do
	if [ -d ${build_tbl[ic]} ]
	then
		echo "-" ${build_tbl[ic]}
		cd ${build_tbl[ic]}
		ant buildAll -lib $ECLIPSE_HOME/plugins/net.sf.ant4eclipse.plugin_0.5.0.rc1/lib/ -lib $ECLIPSE_HOME/plugins/org.apache.ant_1.6.5/lib/ -lib $ECLIPSE_HOME/plugins/org.junit_3.8.1/ -lib $ECLIPSE_HOME/plugins
		if [ $? -ne 0 ];
		then 
			set ANT_HOME=$DUMMY
			exit 1
		fi
		cd ..
	else
		echo ${build_tbl[ic]} "doesn't exist."
	fi
	ic=ic+1
done

#---------------------------------------------------------------------------
# 必要なファイルをzip
#
#
#---------------------------------------------------------------------------
mkdir ./rtsystemeditor_1.1.0
#find ./ -name '*aist*.jar' -exec cp -p {} . \;
ic=0
declare name
while [ $ic -lt $num ]
do
	name=${build_tbl[ic]}"_1.1.0.jar"
	cp -p ${build_tbl[ic]}/jar/$name ./rtsystemeditor_1.1.0 
	ic=ic+1
done
rm rtsystemeditor_1.1.0.zip
zip rtsystemeditor_1.1.0.zip -r ./rtsystemeditor_1.1.0

rm -rf ./rtsystemeditor_1.1.0



#---------------------------------------------------------------------------
#---------------------------------------------------------------------------
set ANT_HOME=$DUMMY


