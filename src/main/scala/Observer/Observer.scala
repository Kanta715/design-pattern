package Observer

trait Observer[A <: Notify] {
 def update(notify: A): Unit
}
