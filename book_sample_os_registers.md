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

# Complex Editing - OS Registers

One of people's first big frustrations with Vim is why yank and cut do not seem
to work from outside of Vim. Because Vim's default register is the unnamed
register, all commands do not modify the OS clipboard unless otherwise
specified.

| Command |                                           |
|---------|-------------------------------------------|
| `"*`    | OS Clipboard                              |
| `"+`    | OS Clipboard (X11 middle click clipboard) |
| `"~`    | Drag and drop clipboard                   |

To put from the OS clipboard, you would need to access the OS Clipboard first:

| Example |                           |
|---------|---------------------------|
| `"*p`   | From OS clipboard, put    |
| `"*dd`  | To OS clipboard, cut line |

#### Exercise

Open the file [ozymandias.txt](ozymandias.txt) in Vim and open
[ozymandias-numbers.txt](ozymandias-numbers.txt) in some basic text editor like
notepad or gedit. Move the number lines from "ozymandias.txt" to
"ozymandias-numbers.txt", and move the poem lines from "ozymandias-numbers.txt"
into "ozymandias.txt". For example, in "ozymandias.txt", you might navigate to
line 1, then type `"*dd` to delete that line into the OS register. Now in
notepad or some other editor, you can use `Ctrl-v` to paste it.
