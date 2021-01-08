###JInJung, InJung interpreter implemented in Java

InJung is the programming language that uses `ㅇ`, `ㅈ`, `ㅊ(<Message>)` only.

But this interpreter has the kinda different grammar that any word, message in `ㅊ()` works without changing the korean letter to the alphabet. That means, you can type any language you want in the message.

This program is developed as unstrict. So you can use `ㅊ`.

Other grammar, `ㅇ` and `ㅈ`, is same with the original language.

Thanks to [HyungJu](https://github.com/HyungJu) to create this language.

## Usage

Notice: This program is only available on Linux CLI. If you want to use it in other OS, download the source code and compile the java class file, Injung.java and run java Injung to use.

Download the release file, injung, and run it on the shell or tty, `./injung`. As you download through the web browser, default path is `/home/<YOURHOMEDIRECTORY>/Downloads/injung`.

# Options

1. `./injung` Only: Run the interpreter on your shell. You can use Ctrl+C or D and typing `ㅈ` only to exit.

2. `./injung --code|-c <CODE>`: Run the code immediately and exit.

3. `./injung <FILE>`: Run the InJung code and exit. The extension of file must be ended as *.ij

4. `./injung --help|-h`: Show the help screen.


