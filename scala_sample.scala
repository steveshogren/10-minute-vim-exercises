package fpinscala.datastructures
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    @annotation.tailrec
    def g(rest: List[A], ret: B) : B = {
      rest match {
        case Nil => ret
        case Cons(x, xs) => g(xs, f(ret, x))
      }
    }
    g(as, z)
  }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((b,a) => f(a,b))

  def concat[A](l: List[List[A]]): List[A] =
    foldRight[A,List[A]](reverse(l), (Cons(a,Nil)))(Cons(_,_))

  def append[A](l: List[A])(a:A): List[A] =
    foldRight[A,List[A]](reverse(l), (Cons(a,Nil)))(Cons(_,_))

  def reverse[A](l: List[A]): List[A] =
    foldLeft[A,List[A]](l, Nil)((b,a) => Cons(a,b))

  def drop[A](l: List[A], n: Int): List[A] = {
    @annotation.tailrec
    def g(rest: List[A], n: Int) : List[A] = {
      if (n > 0) g(tail(rest), n-1)
      else rest
    }
    g(l, n)
  }

  def productL(ns: List[Double]) =
    foldLeft(ns, 1.0)(_ * _)

  def length2[A](as: List[A]): Int =
    foldRight(as, 0)((_,b) => 1 + b)

  @annotation.tailrec
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] =
    as match {
      case Cons(h,t) if f(h) => dropWhile(t)(f)
      case _ => as
  }


  def init[A](l: List[A]): List[A] = {
    @annotation.tailrec
    def g(rest: List[A], ret: List[A]) : List[A] = {
      rest match {
        case Cons(x, Nil) => ret
        case Cons(x, Cons(_, Nil)) => Cons(x, ret)
        case Cons(x, Cons(y, ys)) => g(Cons(y, ys), Cons(x, ret))
        case Nil => Nil
      }
    }
    reverse(g(l, Nil))
  }

  def lengthL[A](as: List[A]): Int =
    foldLeft(as, 0)((b,_) => 1 + b)

  def sumL(ns: List[Int]) =
    foldLeft(ns, 0)(_ + _)

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)

}
