package Observer

trait Observer[A] {
 def update(notify: A): Unit
}
