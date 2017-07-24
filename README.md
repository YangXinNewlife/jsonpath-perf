
# Example Project for Testing JsonPath

date : 2017-07-24

## How to use it

Setp 1 : Generate large files

```sh
python gen_json.py --iters 100 -o jsonfiles/100.json

```

Step 2 : Do benchmarking

```sh
./gradlew run
```

You Will see the result like this:

```text
./gradlew run                                                                                                                        ~/work/tmp/json-perf  

> Task :compileJava
warning: [options] bootstrap class path not set in conjunction with -source 1.7
1 warning

> Task :run
============= Benchmarking Results =============
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Path jsonfiles/1000.json iterations 10000: Elasped time : 3815
Path jsonfiles/100.json iterations 10000: Elasped time : 383
Path jsonfiles/a.json iterations 10000: Elasped time : 51


BUILD SUCCESSFUL in 5s
2 actionable tasks: 2 executed
```

## Reference

1. https://github.com/json-path/JsonPath
2. https://docs.python.org/3/library/argparse.html
2. https://docs.gradle.org/3.3/userguide/application_plugin.html
3. https://docs.gradle.org/3.3/userguide/java_plugin.html

