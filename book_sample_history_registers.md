This is a sample section from the in-progress book
[10 Minute Vim](https://leanpub.com/deliberatevim/) available DRM-free on
Leanpub. If you find it helpful, the book has 50+ more sections like this!

The included exercises _are_ contrived - they are designed to teach you the
muscle memory needed to perform the specific command. The exercises should be
performed on a pristine file: we recommend cloning this repository with `git
clone git@github.com:steveshogren/10-minute-vim-exercises.git`and running a `git
checkout` after each exercise to bring the files back to their pristine state.

Other Samples:
* [Sample Section: Text Object Edits](book\_sample\_delimited\_edits.md)
* [Sample Section: Completion](book\_sample\_ctrln.md)
* [Sample Section: Multiple Repeat](book\_sample\_multiple\_repeat.md)

# Complex Editing - History Registers

Vim offers you a number of registers for storing text. These registers allow you
to yank and delete dozens of times, knowing each text block is still accessible.
You are no longer restricted to copying only a single piece of text!

Vim has several kinds of registers. Named registers let you choose the register
name when you yank or delete. The history registers keep the last nine deletes.
The default register is used when no arguments are supplied, and the OS register
is how you access the operating system's clipboard.

You can always see all the active registers:

| Command |                               |
|---------|-------------------------------|
| `:reg`  | See contents of all registers |

When looking at the registers, `<ENTER>` or any command will close the view. To
paste the contents of a register, prefix your `p` command with `​"{register}`.
Like any put, these can be repeated with a repetition.

|           | Grammar                    |
|-----------|----------------------------|
| named put | `​"{register}[repetition]p` |

Examples:

| Command |                                              |
|---------|----------------------------------------------|
| `​"zp`   | From `z` register, put contents              |
| `​"3p`   | From number 3 history register, put contents |
| `​"g5p`  | From `g` register, perform 5 puts            |

## History Registers (aka Number Registers)

The history registers are a bit odd, but for a good reason. 

The `​"0` register stores the most recent yank. Yanking three times will not
store all three yanks to the history registers, each successive yank will
overwrite the `​"0` register.

The `​"1` through `​"9` registers store the last nine deletes, cuts, or changes.
Deleting three times will populate first the `​"1` register, then `​"1` and `​"2`,
then `​"1`, `​"2`, and `​"3`. Each successive delete will shift all the registers
by one. After three deletes in a row, the first deleted text will be in `​"3`,
the second deleted in `​"2`, and the last deleted in `​"1`.

The fact that yanks do not get put into the 1-9 registers is often confusing.
This is because of the common case of yanking a piece of text into the unnamed
register `​""​` and replacing several other blocks of text with it. You might yank
the text, visually select the next block, and perform a put to replace it. This
has the effect of replacing your `​""​` register contents with that of the
visually selected region! When you go to do the next block, your originally
yanked block has been replaced! To address this problem, you can always put from
the 0 register `​"0`, knowing that your original yank is preserved.

### Exercise

Use the file [clojure\_sample.clj](clojure\_sample.clj) and rename the variable
`cid` to `classId` using the `​"0` register, `ye`, and `de`. Start by deleting
the first `cid`, then typing `classId`. Yank the whole word, then search for the
next `cid`. Use `de` to delete it, and then `​"0P` to put the last yanked text
back. Replace all of them this way, then replace `sid` with `studentId`, and
`d/` with `data/`.

### Black Hole Register

The black hole register is used to cut, delete, or change text if you don't want
Vim to modify your history registers.


| Command |                     |
|---------|---------------------|
| `​"_`    | Black hole register |

A common case would be performing several deletes you want to move, then
deleting some text you never want back. You want to keep your previous deletes
ready, without having them overwritten.

### Exercise 

Use the file [extra\_junk\_annabel\_lee.txt](extra\_junk\_annabel\_lee.txt) to
practice the black hole and history registers. The poem is out of order, some of
the lines appear too early, and you need to reorder them. Every time you find a
line with a number that appears too soon (e.g. line 5 between lines 1 and 2),
use `dd` to cut it into a history register. When you find a line like "EXTRA
LINE" use `​"_dd` to delete it into the black hole register, leaving your history
registers untouched. When you come to the correct location for a history line,
use `​"Xp` to put it, where X is the correct history register number. On easy
mode, you are allowed to use `:reg` to see what your history looks like. Hard
mode is when you do it without the use of `:reg`.
