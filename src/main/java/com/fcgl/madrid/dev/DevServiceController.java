package com.fcgl.madrid.dev;

import com.fcgl.madrid.points.payload.InternalStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DevServiceController {

  DevService devService;

      @GetMapping(value="/fallback")
      public ResponseEntity<InternalStatus> failureWithFallback() {
          return devService.failureWithFallback();
      }
}
