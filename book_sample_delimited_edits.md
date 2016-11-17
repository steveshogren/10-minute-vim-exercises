Complex Editing - Delimited Edits
---------------------------------

Vim edit commands have another motion syntax for delimited-edits. A
delimited-edit allows for the action to grow in both directions up to a
delimiter. You must provide a both a Scope and a Delimiter. The Scope indicates
how far the region should extend, and the Delimiter is what character the region
should use. Your cursor must also be inside the desired Delimiters.

The two Scopes are `a` and `i`. You can remember `a` as "All", and `i` as
"Inside". The `a` Scope will include both the contents inside the Delimiter and
the Delimiters as well. The `i` Scope will only include the contents inside the
delimiters.

The Delimiters are restricted to common text Delimiters. `` ( ) [ ] < > { } " ' ` w p s t `` are all valid Delimiters.

| Command | Meaning  |
|-----|---------------------------------------------------------------|
| `w` | Word                                                          |
| `p` | Paragraph                                                     |
| `s` | Sentence                                                      |
| `t` | XML/HTML Tag (e.g. the TEXT in &lt;body&gt;TEXT&lt;/body&gt;) |

Your cursor must be inside the Delimiter to work. Vim will grow the region in
either direction until it finds the Delimiter, so you can place your cursor
anywhere inside the Delimiters. Delimited-edits also work across multiple lines.

#### Examples

| Command | Meaning                                     |
|---------|---------------------------------------------|
| `da(`   | Delete contents AND surrounding parenthesis |
| `dis`   | Delete current sentence                     |
| `dip`   | Delete inside current paragraph             |
| `diw`   | Delete current word                         |
| `daw`   | Delete current word and following space     |
| `yi<`   | Yank inside of &lt; and &gt;                |
| `vi'`   | Visual select inside '                      |

#### Exercise - Delete

Use the file [beowulf\_and\_grendel\_grapple.txt](region/beowulf\_and\_grendel\_grapple.txt). You will find a
story filled with random numbers all containing the number "0", sometimes
surrounded with punctuation. Remove all numbers, quotes, angle brackets, curly
brackets, square brackets, and parentheses using search `/` and delimited
regions. Search for the number "0", and use `n` to find the next number. Then
use delimited regions to swiftly delete the whole number and any surrounding
punctuation.

#### Exercise - Visual

Use the file "html\_sample.html". Capitalize using all the words inside angle
brackets, quotes, parens, and tags. Use `v` to visually select the characters,
then `~` to capitalize all the selected characters. For example, &lt;html&gt;
can be changed to &lt;HTML&gt; by moving the cursor inside the angle brackets
and typing `vi<~`

#### Exercise - Yank

Use the file "yank-delimited.txt" to yank and move the contents of the angle
brackets, quotes, parens, and move it to the line below. So the line like:

    (There is a )
    place where the sidewalk ends

Should end up looking like:

    (There is a )
    There is a place where the sidewalk ends

To transform this line, you can use yank inside delimiter `yi(` to yank the
words and space, then move your cursor down a line and paste at the start of the
line with `P`.
