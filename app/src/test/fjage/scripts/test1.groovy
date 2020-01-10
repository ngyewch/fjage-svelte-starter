import org.arl.fjage.Platform
import org.arl.fjage.RealTimePlatform
import org.arl.fjage.connectors.WebServer
import org.arl.fjage.connectors.WebSocketConnector
import org.arl.fjage.remote.MasterContainer

final Platform platform = new RealTimePlatform()
final MasterContainer container = new MasterContainer(platform)

final int port = 8888
final WebServer webServer = WebServer.getInstance(port)
webServer.add('/', new File("web"), "no-cache")
container.addConnector(new WebSocketConnector(port, "/ws", true))

container.add(new TestAgent())

platform.start()
println("Started")
println("URL: http://localhost:$port/")
println("DEV URL: http://localhost:$port/?dev")
