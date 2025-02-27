package com.ygl.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygl.entity.UserInfoPo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DeepseekApiRestService
 * @Description: deepseek
 * @Author:tangmw
 * @Date 2025-02-20
 * @Version 1.0
 */
@RestController
@RequestMapping("/deepseek")
@Valid
public class DeepseekApiRestService {



    @Getter
    @Setter
    public static class OllamaResponse {
        private String model;
        private String created_at;
        private String response;
        private boolean done;
        private String done_reason;
        private List<Long> context;
        private long total_duration;
        private long load_duration;
        private int prompt_eval_count;
        private long prompt_eval_duration;
        private int eval_count;
        private long eval_duration;

        // 增强数据清洗方法
        public String getCleanResponse() {
            return response.replaceAll("<.*?>", "")
                    .replaceAll("\\u003c/?think\\u003e", "") // 处理unicode标签
                    .replaceAll("\n{2,}", "\n")
                    .trim();
        }
    }

    // 在类中添加ObjectMapper实例
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("chat")
    public ResponseEntity<String> chat(@RequestBody Map<String, Object> req) {
        try {
            // 构建Ollama API请求参数
            Map<String, Object> ollamaRequest = new HashMap<>();
            ollamaRequest.put("model", "deepseek-r1:1.5b"); // 根据实际模型名称调整
            ollamaRequest.put("prompt", req.get("prompt"));
            ollamaRequest.put("stream", false);
            // 发送请求到本地Ollama服务
            String ollamaUrl = "http://localhost:11434/api/generate";
            // 发送请求部分保持不变...
            ResponseEntity<String> response = restTemplate.postForEntity(ollamaUrl, ollamaRequest, String.class);
            System.out.println(response.getBody());
            // 新增解析逻辑
            // 完整解析流程
            String rawResponse = response.getBody();
            OllamaResponse ollamaResp = mapper.readValue(rawResponse, OllamaResponse.class);
            return ResponseEntity.ok(ollamaResp.getCleanResponse());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("请求失败: " + e.getMessage());
        }
    }
}
