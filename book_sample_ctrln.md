This is a sample section from the in-progress book
[10 Minute Vim](https://leanpub.com/deliberatevim/) available DRM-free on
Leanpub. If you find it helpful, the book has 50+ more sections like this!

The included exercises _are_ contrived - they are designed to teach you the
muscle memory needed to perform the specific command. The exercises should be
performed on a pristine file: we recommend cloning this repository with `git
clone git@github.com:steveshogren/10-minute-vim-exercises.git`and running a `git
checkout` after each exercise to bring the files back to their pristine state.

## Other Free Samples:
* [Sample Section: History Registers](book\_sample\_history\_registers.md)
* [Sample Section: Text Object Edits](book\_sample\_delimited\_edits.md)
* [Sample Section: Multiple Repeat](book\_sample\_multiple\_repeat.md)

# Convenience Editing

Vim (and Vim plugins inside other IDE's) do not offer out-of-the-box
semantic-aware IDE features like auto-complete and "go to definition". While the
Vim editor has many plugins for extra features, we want to focus on what can be
had in the default experience. The base Vim installation offers a suite of
IDE-lite commands that fulfill the "80/20" rule of value: 80% of the value can
be had for 20% of the cost. Instead of attempting to build a full AST of your
source code for auto-complete and navigation, Vim provides basic navigation and
auto-complete based on text searches of your files.

While in no way does this substitute for the full set of features in a
semantic-aware IDE, they are still extremely useful. These commands derive the
most power from the simple fact that they work in every text file, in any
language, and without any setup.

## Convenience Editing - Completion a.k.a "auto-complete"

Vim provides a basic auto-complete based off text found elsewhere in any open file.

| Command  |                              |
|----------|------------------------------|
| `Ctrl-n` | Cycle to next completion     |
| `Ctrl-p` | Cycle to previous completion |

When in insert mode, type `Ctrl-n` or `Ctrl-p` to list and iterate through the
available options. When an option is selected, it is already "inserted" in the
text, and no further command is needed to "confirm". If you do not wish to use
the inserted text, `Ctrl-p` will return you to your original text.

| Command        |                                 |
|----------------|---------------------------------|
| `Ctrl-xCtrl-f` | Start match on next file name   |
| `Ctrl-xCtrl-l` | Start match on whole line match |

The file name and whole line completion will start the cycle, then you can use
`Ctrl-n` and `Ctrl-p` to cycle as usual.

### Exercise

Use the file [longWords.txt](longWords.txt) to recreate the first 14 lines
starting at line 16. Start typing each word, then use either `Ctrl-p`, `Ctrl-n`,
or `Ctrl-xCtrl-l` to complete it - no copy, delete, yank, etc.
