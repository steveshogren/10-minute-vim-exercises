This is a sample section from the in-progress book
[10 Minute Vim](https://leanpub.com/deliberatevim/) available DRM-free on
Leanpub. If you find it helpful, the book has 50+ more sections like this!

The included exercises _are_ contrived - they are designed to teach you the
muscle memory needed to perform the specific command. The exercises should be
performed on a pristine file: we recommend cloning this repository with `git
clone git@github.com:steveshogren/10-minute-vim-exercises.git`and running a `git
checkout` after each exercise to bring the files back to their pristine state.

Other Samples:
* [Sample Section: History Registers](book\_sample\_history\_registers.md)
* [Sample Section: Text Object Edits](book\_sample\_delimited\_edits.md)
* [Sample Section: Completion](book\_sample\_ctrln.md)

# Complex Editing - Multiple Repeat Commands

Vim allows you to perform an Ex command on any line matching a certain search
pattern. The grammar is:

| Examples                       |                              |
|--------------------------------|------------------------------|
| multiple repeat                | `:[range]g/{pattern}/{cmd}`  |
| multiple repeat inverted match | `:[range]g!/{pattern}/{cmd}` |

There is a huge number of Ex commands, and the full list is available
[here](http://vimdoc.sourceforge.net/htmldoc/vimindex.html#ex-cmd-index). The
most common used are:

| Examples  |                |
|-----------|----------------|
| `d`       | Delete line(s) |
| `m{LINE}` | Move line(s)   |
| `t{LINE}` | Copy lines(s)  |
| `p`       | Print line(s)  |

As an interesting aside, we could search for every line that matches using a
regular expression `{re}` and print it using the global command `:g/{re}/p`.
This is the source of name of the command `grep`!

| Examples                |                                                   |
|-------------------------|---------------------------------------------------|
| `:g/^$/d`               | delete all empty lines                            |
| `:g/test/t$`            | copy all lines with `test` to the end of the file |
| `:g/horse/p`            | print all lines with `horse`                      |
| `:g!/public function/d` | delete all lines without `public function`        |

#### Exercise - Edit and Delete

Use the file "ozymandias.txt" to prepend "Line " to all lines with poetry on
them with a single `:g` command. Then delete the lines that do not have any
poetry on them with a single `:g` command.

#### Exercise - Move

On a fresh copy of "ozymandias.txt", move all lines with just a number to the
bottom of the file.

#### Exercise - Print

On a fresh copy of "ozymandias.txt", print all lines with poetry.
