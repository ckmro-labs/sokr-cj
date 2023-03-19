(defproject sokr-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 ; web framework
                 [prismatic/schema "1.4.1"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [ring/ring-json "0.5.1"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 ;database
                 [toucan "1.18.0"]
                 [org.postgresql/postgresql "42.4.0"]
                 [com.zaxxer/HikariCP "2.6.1"]]
  :main ^:skip-aot sokr-clj.core
  :repl-options {:init-ns sokr-clj.core})
