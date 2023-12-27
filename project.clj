(defproject me.vedang/clj-logging "1.0.0-SNAPSHOT"
  :description "Dummy to set up Log4J correctly for Clojure projects"
  :url "https://github.com/vedang/clj-logging"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.11.2"]]}
             :test {:jvm-opts ^:replace ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/log4j2-factory"
                                         "-Dorg.eclipse.jetty.util.log.class=org.eclipse.jetty.util.log.Slf4jLog"
                                         "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"
                                         "-Dlog4j2.configurationFile=log4j2-test.xml"
                                         "-Dlogging.level=DEBUG"]}}
  :dependencies [;; Set up Log4J2 as the logging backend with proper
                 ;; log library conflict resolution.

                 ;; Use log4j2 as the primary logging library
                 [org.apache.logging.log4j/log4j-api "2.23.1"]
                 [org.apache.logging.log4j/log4j-core "2.23.1"]
                 ;; Needed for logging from inside javax.servlet
                 [org.apache.logging.log4j/log4j-web "2.23.1"]

                 ;; Use pedestal.log as the primary clojure facade
                 [io.pedestal/pedestal.log "0.6.4"]
                 ;; Use jsonista.core to format log as json
                 [metosin/jsonista "0.3.8"]

                 ;; Use SLF4j as the primary facade for gathering all logs.
                 [org.apache.logging.log4j/log4j-slf4j2-impl "2.23.1"]
                 [org.slf4j/slf4j-api "2.0.12"]

                 ;; Use LMAX Disruptor to enable Async Logging NOTE:
                 ;; This dep needs to be *pinned* to 3.4.4, because
                 ;; 4.x breaks compatibility with log4j2. See
                 ;; https://github.com/apache/logging-log4j2/issues/1829
                 ;; and update version once the issue is fixed.
                 [com.lmax/disruptor "4.0.0"]

                 ;; Redirect everything via the SLF4J API

                 ;; Apache Commons logging
                 [org.slf4j/jcl-over-slf4j "2.0.12"]
                 ;; Log4j 1.x
                 [org.slf4j/log4j-over-slf4j "2.0.12"]
                 ;; OSGI LogService
                 [org.slf4j/osgi-over-slf4j "2.0.12"]
                 ;; Java util logging
                 [org.slf4j/jul-to-slf4j "2.0.12"]

                 ;; DONE
                 ]

  :exclusions
  [;; Exclude transitive dependencies on all other logging
   ;; implementations, including other SLF4J bridges.
   commons-logging
   log4j ;; 1.x
   ch.qos.logback/logback-classic
   ch.qos.logback/logback-core
   org.slf4j/simple
   org.slf4j/slf4j-jcl
   org.slf4j/slf4j-nop
   org.slf4j/slf4j-log4j12
   org.slf4j/slf4j-log4j13]
  :jvm-opts
  ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/log4j2-factory"
   "-Dorg.eclipse.jetty.util.log.class=org.eclipse.jetty.util.log.Slf4jLog"
   "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"
   "-Dlog4j2.configurationFile=log4j2.xml"
   "-Dlogging.level=INFO"])
