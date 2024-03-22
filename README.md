# me.vedang/logger

This template creates a logger component that I use in my code. Install the template as shown below to read more.

## Usage

FIXME: write usage documentation!

This is a template project for use with [deps-new](https://github.com/seancorfield/deps-new).
As originally generated, it will produce a new library project when run:

    $ clojure -Sdeps '{:deps {io.github.vedang/clj-logging {:git/sha "17f4e82ad4dbbda91a35bf10f22e58b1d29655af"}}}' -Tnew create :template me.vedang/logger :name me.vedang.latestproject/logger

Assuming you have installed `deps-new` as your `new` "tool" via:

```bash
clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new
```

> Note: once the template has been published (to a public git repo), the invocation will be the same, except the `:local/root` dependency will be replaced by a git coordinate.

Run this template project's tests (by default, this just validates your template's `template.edn`
file -- that it is valid EDN and it satisfies the `deps-new` Spec for template files):

    $ clojure -T:build test

## License

Copyright © 2024 Vedang Manerikar

_EPLv1.0 is just the default for projects generated by `deps-new`: you are not_
_required to open source this project, nor are you required to use EPLv1.0!_
_Feel free to remove or change the `LICENSE` file and remove or update this_
_section of the `README.md` file!_

Distributed under the Eclipse Public License version 1.0.
