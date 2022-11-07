package Singleton

object Main {

  def main(args: Array[String]): Unit = {
    println("[ OBJECT ] =============================")
    val singleton:  SingletonObject.type = SingletonObject
    val singleton2: SingletonObject.type = SingletonObject
    if (singleton == singleton2) println("同じインスタンスです") else println("違うインスタンスです")
    singleton  + 10
    singleton2 + 1000
    println(singleton .count)
    println(singleton2.count)
    // 同じインスタンスです
    // 1010
    // 1010

    println("")
    println("[ CLASS ] ==============================")
    println("")

    val singletonClass:  SingletonClass = new SingletonClass
    val singletonClass2: SingletonClass = new SingletonClass
    if (singletonClass == singletonClass2) println("同じインスタンスです") else println("違うインスタンスです")
    singletonClass  + 10
    singletonClass2 + 1000
    println(singletonClass .count)
    println(singletonClass2.count)
    // 違うインスタンスです
    // 10
    // 1000

    println("")
    println("[ ENUM ] ==============================")
    println("")

    val singletonEnum: SingletonEnum.type = SingletonEnum
    val baseball:      SingletonEnum.Baseball.type = SingletonEnum.Baseball
    val baseball2:     SingletonEnum.Baseball.type = SingletonEnum.Baseball
    if (baseball == baseball2) println("同じインスタンスです") else println("違うインスタンスです")
    baseball  + 10
    baseball2 + 1000
    println(baseball .count)
    println(baseball2.count)
    // 同じインスタンスです
    // 1010
    // 1010
  }
}
