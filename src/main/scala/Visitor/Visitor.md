Composite のような同一視したクラスを型ごとで処理を分けたい場合のパターン

Composite パターンのように Directory の中で Entry のインスタンスごとに処理を分けたい場合、パターンマッチなどを使う必要がある。
<br>
Visitor パターンだと Visitor にインスタンスごとの処理を書くだけ。
<br>
個人的には Composite パターンのようにデータと処理は同じクラスに閉じ込めた方が使う側がコードの意図を読み取りやすいと感じた。パターンマッチなどを避けられるメリットよりも Visitor パターンを採用後の可読性低下のデメリットの方が大きいと思う。
```scala
// Composite
case class Directory(entrys: Seq[Entry]) {
  def func(): Unit = for {
    entry <- entrys
  } yield {
    entry match {
      case File(_)      => ???
      case Directory(_) => ???
    }
  }
}

// Visitor
object XVisitor {
  def visit(file: File)     : Unit = ???
  def visit(dir:  Directory): Unit = ???
}

case class File(v: Any) {
  def accept(visitor: XVisitor): Unit = visitor.visit(this)
}
case class Directory(v: Any) {
  def accept(visitor: XVisitor): Unit = visitor.visit(this)
}

val dir    = Directory(files)
val vistor = XSVisitor.visit(dir)
```