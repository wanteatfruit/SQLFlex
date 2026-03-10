# SQLFlex
A tool for dialect-agnostic SQL parsing via LLM-based segmentation.

## Setup
To run SQLFlex, here are the steps to set up the environment and install the necessary dependencies:

Using `conda` is recommended for setting up the environment. You can create a new conda environment with the following command:
```bash
conda create -n sqlflex python=3.10
conda activate sqlflex
```
In the root directory, run the following commands to install the required dependencies:
```bash
pip install -r ./sqlflex/requirements.txt
pip install antlr4-tools==0.2.1
pip install antlr4-python3-runtime==4.13.2
```
In the same directory, run the following command to install the `sqlflex` package in editable mode. SQLFlex is designed into a python package to facilitate its usage in other projects:
```bash
pip install -e .
```
Then, run the following command to generate the grammar-based parser:
```bash
./sqlflex/gen_parser.sh
```
Finally, set up your OPENAI_KEY, place it inside an `.env` file in the root directory:
```bash
OPENAI_KEY=your_openai_key_here
```

## Usage

SQLFlex is designed into a python package to facilitate its usage. The APIs of SQLFlex are defined in the `./sqlflex/__init__.py` file, which can be used to analyze or rewrite SQL queries.

An example usage of using SQLFLex to parse the example query in the paper, and rewrite the `!<` operator to `<=` is as follows:
```python
from sqlflex import parse, pretty_print, transform, findall

sql_input = """
SELECT TOP 10 *
FROM Sales
WHERE (tot / 2) !< 8 AND year < 2025
OPTION (FAST 10) ;
"""

ast,stats,_ = parse(sql_input, dialect='TSQL')

# Suppose we want to detect an anti-pattern: Use <= instead of !<
from sqlflex.sqlast.ASTNodes import Operation
from sqlflex import findall, transform, pretty_print
not_less_than: list[Operation] = findall('Operation', ast, filter_func=lambda x: x.op == '!<')
for expr in not_less_than:
  print(f"Use <= instead of !< in expression: {pretty_print(expr)}")
  
# Fix: Use <= instead of !<
def fix_not_less_than(node):
    if isinstance(node, Operation) and node.op == '!<':
        node.op = '<='
fixed_ast = transform(ast, fix_not_less_than, inplace=False)
print(f"Fixed query: {pretty_print(fixed_ast)}")
```
We show its output and more details (including printed logs of each step in the segmentation loop) in the `demo.ipynb` file.

## Extending

SQLFlex uses SQL-92 as its base grammar by default. We also included SQL:2003 grammar files as an experimental feature, you can alter the script `gen_parser.sh` to generate parser for SQL:2003. In addition, you should also set `self.use_sql03` to `True` in `sqlflex/llm/ExpressionSegmenter.py` to enable SQL:2003 anchors in expression parsing.