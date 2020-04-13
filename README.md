# github-search-cli

Search Github for repositories tagged with particular topics, under a given organisation or login name.

I needed this for a small internal application (a gallery of repositories) and wrote this utility (and accompanying [library](https://github.com/eamonnsullivan/github-search)) to generate the JSON file of raw data about the repositories.

## Installation

Download from https://github.com/eamonnsullivan/github-search-cli.

## Usage

The library assumes your Github access token is defined in your environment as GITHUB_ACCESS_TOKEN. It will need `repo` and `read:org` permissions, at a minimum.

Run the project directly:

    $ clojure -m eamonnsullivan.github-search-cli my-org topic1,topic2,topic3

Run the project's tests

    $ clojure -A:test:runner

Build an uberjar:

    $ clojure -A:uberjar

Run that uberjar:

    $ java -jar github-search-cli.jar my-org topic1,topic2,topic3

## Options

    -p or --page-size <num> sets paging size (default 25)

## Examples

...

### Bugs

...

## License

Copyright © 2020 Eamonn

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
