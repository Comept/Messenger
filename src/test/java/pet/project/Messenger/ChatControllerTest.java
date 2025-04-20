//package pet.project.Messenger;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.web.context.request.async.DeferredResult;
//
//import pet.project.Messenger.dto.MessageDto;
//import pet.project.Messenger.model.Message;
//import pet.project.Messenger.servise.MessagesService;
//import pet.project.Messenger.web.api.ChatController;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebMvcTest(ChatController.class)
//public class ChatControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private MessagesService messageService;
//
//    @InjectMocks
//    private ChatController chatController;
//
//    private UUID chatId;
//    private Message message;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        chatId = UUID.randomUUID();
//        message = new Message(chatId, UUID.randomUUID(), "Test message");
//    }
//
//    @Test
//    @WithMockUser
//    public void testGetAllMessages() throws Exception {
//        List<MessageDto> messages = List.of(new MessageDto(message));
//        when(messageService.getMessagesByChatId(chatId)).thenReturn(messages);
//
//        mockMvc.perform(get("/api/chats/{id}/messages/all", chatId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].text").value("Test message"))
//                .andExpect(jsonPath("$[0].chatId").value(chatId.toString()));
//
//        verify(messageService, times(1)).getMessagesByChatId(chatId);
//    }
//
//    @Test
//    @WithMockUser
//    public void testGetChatMessage() throws Exception {
//        MvcResult result = mockMvc.perform(get("/api/chats/{id}/messages", chatId))
//                .andExpect(request().asyncStarted())
//                .andReturn();
//
//        DeferredResult<?> deferredResult = (DeferredResult<?>) result.getAsyncResult();
//        assertNotNull(deferredResult);
//    }
//
//    @Test
//    @WithMockUser
//    public void testSaveMessage() throws Exception {
//        when(messageService.saveMessage(eq(chatId), any(), eq("Test message"))).thenReturn(message);
//
//        mockMvc.perform(post("/api/chats/{id}/messages", chatId)
//                        .contentType("application/json")
//                        .content("\"Test message\""))
//                .andExpect(status().isOk());
//
//        verify(messageService, times(1)).saveMessage(eq(chatId), any(), eq("Test message"));
//    }
//}
