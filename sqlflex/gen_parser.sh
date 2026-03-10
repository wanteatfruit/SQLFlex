#!/bin/zsh

# run this script from root folder of the project

SQL_VERSION="sql92"

# Parse options
while getopts "s:g:o:" opt; do
  case ${opt} in
    s ) SQL_VERSION=$OPTARG ;;  # Set SQL standard version
    * ) echo "Usage: $0 -s <sql_version>"; exit 1 ;;
  esac
done


if [[ ! "$SQL_VERSION" =~ ^(sql92|sql03)$ ]]; then
    echo "Invalid SQL version. Only 'sql92' and 'sql03' are supported."
    exit 1
fi

if [[ "$SQL_VERSION" == "sql92" ]]; then
    echo "Generating parser for SQL-92"
    cd sqlflex/grammar
    antlr4 -Dlanguage=Python3 ./*.g4 -visitor -listener -o ../parser 
    exit 0
fi


# echo "Generating parser for $SQL_VERSION"

# cd sqlflex/grammar/$SQL_VERSION

# # generate parser at same output directory
# antlr4 -Dlanguage=Python3 ./*.g4 -visitor -listener -o ../../parser 
