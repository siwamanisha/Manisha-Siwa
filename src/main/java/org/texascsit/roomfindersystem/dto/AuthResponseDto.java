package org.texascsit.roomfindersystem.dto;

public class AuthResponseDto {
    private  String  accessToken;
    private  long expirationTime;

    public AuthResponseDto(String accessToken, long expirationTime) {
        this.accessToken = accessToken;
        this.expirationTime = expirationTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
