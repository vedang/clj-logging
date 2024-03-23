# me.vedang/logger : Emitting Structured Logs from your Clojure code

This is a `deps-new` template which creates a logger component that I use in my code. I reproduce this same logging code in every new project using this template

## Usage

To install this code, run the following command inside your project

    $ clojure -Sdeps '{:deps {io.github.vedang/clj-logging {:git/sha "17f4e82ad4dbbda91a35bf10f22e58b1d29655af"}}}' -Tnew create :template me.vedang/logger :name your.group.artifact/logger

Note: The command above assumes you have installed `deps-new` as your `new` "tool" via:

```bash
clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new
```

This is create a folder called `logger`. To use this folder, you can add an alias as follows to your main `deps.edn` file:

```clojure
:logs-dev
 {:extra-deps {me.vedang/logger {:local/root "logger"}}
  :jvm-opts
   ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/log4j2-factory"
    "-Dorg.eclipse.jetty.util.log.class=org.eclipse.jetty.util.log.Slf4jLog"
    "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"
    "-Dlog4j2.configurationFile=logger/log4j2-dev.xml"
    ;; Change logging.level to one of TRACE, DEBUG, INFO, WARN, ERROR
    ;; depending on requirement during development
    "-Dlogging.level=DEBUG"]}
```

## Developing the template

Run this template project's tests (by default, this just validates your template's `template.edn`
file -- that it is valid EDN and it satisfies the `deps-new` Spec for template files):

    $ clojure -T:build test

## License

Copyright © 2024 Vedang Manerikar

Distributed under the Eclipse Public License version 1.0.
