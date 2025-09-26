package sv.edu.udb.msgconverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import sv.edu.udb.controller.response.CartResponse;

@Component
@RequiredArgsConstructor
public class CustomMessageConverter implements MessageConverter {
    private final ObjectMapper objectMapper;

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            return new Message(jsonString.getBytes(), messageProperties);
        }
        catch (JsonProcessingException e) {
            throw new MessageConversionException("Error converting object to JSON", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            String jsonString = new String(message.getBody());
            return objectMapper.readValue(jsonString, CartResponse.class);
        } catch (Exception e) {
            throw new MessageConversionException("Error converting JSON to object", e);
        }
    }
}
