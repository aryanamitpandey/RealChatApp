package Developer.RealChatApp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker 
public class WebSocketConfig implements  WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set message broker
        registry.enableSimpleBroker("/topic"); //topic/chartRoom1 in this box
        registry.setApplicationDestinationPrefixes("/app");
        //expect  message with /app/ sendmessage

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:8081").withSockJS();//this methods to access the more users to chat
    
    }

}