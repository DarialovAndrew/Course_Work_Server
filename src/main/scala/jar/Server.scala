package jar

import java.io.{DataInputStream, DataOutputStream}
import java.net.{ServerSocket, Socket}

object Server {

  def main(args: Array[String]): Unit = {
    val port: Int = 8891
    val t: Thread = new Server_1(port)
    t.start()
  }

}

class Server_1(port: Int) extends Thread {

  private val serverSocket: ServerSocket = new ServerSocket(port)

  override def run(): Unit = {
    while (true) try {
      val server: Socket = serverSocket.accept()
      val in: DataInputStream = new DataInputStream(server.getInputStream)
      val out: DataOutputStream = new DataOutputStream(server.getOutputStream)
      out.writeLong(System.currentTimeMillis())
      server.close()
    } catch {
      case e: Exception => println("Something went wrong")

    }
  }
}