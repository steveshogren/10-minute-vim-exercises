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
* [Sample Section: OS Registers](book\_sample\_os\_registers.md)

# Complex Editing - Text Object Edits

Vim commands have another motion syntax for editing text objects. A text object
edit allows for the action to grow in both directions up to a delimiter. You
must provide a both a scope and a text object. The scope indicates how far the
region should extend, and the text object is what character the region should
use. Your cursor must also be inside the desired text object.

The two scopes are `a` and `i`. You can remember `a` as "A", and `i` as
"Inside". The `a` scope will include both the contents inside the text object
and the text object as well. The `i` scope will only include the contents inside
the text objects.

Note that there are caveats for white space surrounding words and
parentheses/braces/etc. when using the `a` scope. The object will include the
whitespace after the object and will include the whitespace before the object
if either; there was no whitespace after the object, or the cursor was in the
whitespace before the object prior to the operation. Note that using the closing
parentheses/braces/etc. will exclude the white space, but the opening one will
include it. Excluding the whitespace surrounding quotes can be achieved using
the `i` scope with a 2 count (i.e. `d2i'`).

The text objects are restricted to common text objects. `` ( ) [ ] < > { } " ' ` w p s t `` are all valid.

| Command | Meaning                                                       |
|---------|---------------------------------------------------------------|
| `w`     | Word                                                          |
| `p`     | Paragraph                                                     |
| `s`     | Sentence                                                      |
| `t`     | XML/HTML Tag (e.g. the TEXT in &lt;body&gt;TEXT&lt;/body&gt;) |

Your cursor must be inside the text object to work. Vim will grow the region in
either direction until it finds the boundaries of the text object, so you can
place your cursor anywhere inside the text object. Text object edits also work
across multiple lines.

The grammar of the text object edits:

| Command          | Definition                          |
|------------------|-------------------------------------|
| scope            | `a i`                              |
| text object      | `` ( ) [ ] < > { } " ' ` w p s t `` |
| action           | `d y c v`                           |
| text object edit | `{action}{scope}{text object}`      |

#### Examples

| Command | Meaning                                     |
|---------|---------------------------------------------|
| `da(`   | Delete contents AND surrounding parenthesis |
| `dis`   | Delete current sentence                     |
| `ci(`   | Change inside parenthesis                   |
| `ciw`   | Change current word                         |
| `dip`   | Delete inside current paragraph             |
| `diw`   | Delete current word                         |
| `daw`   | Delete current word and following space     |
| `yi<`   | Yank inside of &lt; and &gt;                |
| `vi'`   | Visual select inside '                      |

#### Exercise - Delete

Use the file
[region/beowulf\_and\_grendel\_grapple.txt](region/beowulf\_and\_grendel\_grapple.txt).
You will find a story filled with random numbers all containing the number `0`,
sometimes surrounded with punctuation. Remove all numbers, quotes, angle
brackets, curly brackets, square brackets, and parentheses using search `/` and
delimited regions. Search for the number `0` with `/0` and use `n` to find the
next number. Then use delimited regions to delete the whole number and any
surrounding punctuation.

#### Exercise - Change

Use the file [html\_sample.html](html\_sample.html). Change all the words inside
angle brackets, quotes, parens, and tags to be the word "cat". For example,
<html> can be changed to <cat> by moving the cursor inside the angle brackets
and typing `ci<cat`

#### Exercise - Visual

Use the file [html\_sample.html](html\_sample.html). Capitalize using all the
words inside angle brackets, quotes, parens, and tags. Use `v` to visually
select the characters, then `~` to capitalize all the selected characters. For
example, &lt;html&gt; can be changed to &lt;HTML&gt; by moving the cursor inside
the angle brackets and typing `vi<~`

#### Exercise - Yank

Use the file [yank-delimited.txt](yank-delimited.txt) to yank and move the
contents of the angle brackets, quotes, parens, and move it to the line below.
So the line like:

    (There is a )
    place where the sidewalk ends

Should end up looking like:

    (There is a )
    There is a place where the sidewalk ends

To transform this line, you can use yank inside delimiter `yi(` to yank the
words and space, then move your cursor down a line and paste at the start of the
line with `P`.
