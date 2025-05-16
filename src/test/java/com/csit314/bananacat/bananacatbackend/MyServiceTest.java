package com.csit314.bananacat.bananacatbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Map;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Mock
    private UserAccountRepository UserRepo;

    @Mock
    private UserProfileRepository ProfileRepo;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private HttpSession mockSession;

    @InjectMocks
    private UserAccountEntity entity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        UserAccountRepositoryInjector.repo = UserRepo;
        UserProfileRepositoryInjector.repo = ProfileRepo;

    }

    @Test
    void testLoginUserAdmin() {
        String email = "admin@email.com";
        String password = "12345678h";
        String hash = "hashed";
        String profile = "admin";

        UserAccountEntity mockAdmin = new UserAccountEntity();
        mockAdmin.setEmail(email);
        mockAdmin.setPassword(hash);

        UserProfileEntity mockProfile = new UserProfileEntity();
        mockProfile.setName(profile);

        when(UserRepo.findByEmail(email)).thenReturn(Optional.of(mockAdmin));
        when(encoder.matches(password, hash)).thenReturn(true);
        when(ProfileRepo.findByNameIgnoreCase(profile)).thenReturn(Optional.of(mockProfile));

        ResponseEntity<?> response = UserAccountEntity.login(encoder, email, password, profile);
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertEquals(mockAdmin, body.get("useraccountR"));
        assertEquals(mockProfile, body.get("userprofileR"));
    }

    @Test
    void testLogoutUserAdmin() {
        when(mockSession.getAttribute("useremail")).thenReturn("admin@email.com");

        ResponseEntity<?> response = entity.logout(mockSession);

        verify(mockSession).invalidate();
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Logout successful", response.getBody());
    }

    @Test
    void testLoginCleaner() {
        String email = "cleaner@email.com";
        String password = "12345678c";
        String hash = "hashed";
        String profile = "cleaner";

        UserAccountEntity mockCleaner = new UserAccountEntity();
        mockCleaner.setEmail(email);
        mockCleaner.setPassword(hash);

        UserProfileEntity mockProfile = new UserProfileEntity();
        mockProfile.setName(profile);

        when(UserRepo.findByEmail(email)).thenReturn(Optional.of(mockCleaner));
        when(encoder.matches(password, hash)).thenReturn(true);
        when(ProfileRepo.findByNameIgnoreCase(profile)).thenReturn(Optional.of(mockProfile));

        ResponseEntity<?> response = UserAccountEntity.login(encoder, email, password, profile);
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertEquals(mockCleaner, body.get("useraccountR"));
        assertEquals(mockProfile, body.get("userprofileR"));
    }

    @Test
    void testLogoutCleaner() {
        when(mockSession.getAttribute("useremail")).thenReturn("cleaner@email.com");

        ResponseEntity<?> response = entity.logout(mockSession);

        verify(mockSession).invalidate();
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Logout successful", response.getBody());
    }

    @Test
    void testloginHomeOwner() {
        String email = "homeowner@email.com";
        String password = "12345678o";
        String hash = "hashed";
        String profile = "home owner";

        UserAccountEntity mockHO = new UserAccountEntity();
        mockHO.setEmail(email);
        mockHO.setPassword(hash);

        UserProfileEntity mockProfile = new UserProfileEntity();
        mockProfile.setName(profile);

        when(UserRepo.findByEmail(email)).thenReturn(Optional.of(mockHO));
        when(encoder.matches(password, hash)).thenReturn(true);
        when(ProfileRepo.findByNameIgnoreCase(profile)).thenReturn(Optional.of(mockProfile));

        ResponseEntity<?> response = UserAccountEntity.login(encoder, email, password, profile);
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertEquals(mockHO, body.get("useraccountR"));
        assertEquals(mockProfile, body.get("userprofileR"));
    }

    @Test
    void testlogoutHomeOwner() {
        when(mockSession.getAttribute("useremail")).thenReturn("homeowner@email.com");

        ResponseEntity<?> response = entity.logout(mockSession);

        verify(mockSession).invalidate();
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Logout successful", response.getBody());
    }

    @Test
    void testloginPlatformManager() {
        String email = "manager@email.com";
        String password = "12345678m";
        String hash = "hashed";
        String profile = "platform manager";

        UserAccountEntity mockPM = new UserAccountEntity();
        mockPM.setEmail(email);
        mockPM.setPassword(hash);

        UserProfileEntity mockProfile = new UserProfileEntity();
        mockProfile.setName(profile);

        when(UserRepo.findByEmail(email)).thenReturn(Optional.of(mockPM));
        when(encoder.matches(password, hash)).thenReturn(true);
        when(ProfileRepo.findByNameIgnoreCase(profile)).thenReturn(Optional.of(mockProfile));

        ResponseEntity<?> response = UserAccountEntity.login(encoder, email, password, profile);
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertEquals(mockPM, body.get("useraccountR"));
        assertEquals(mockProfile, body.get("userprofileR"));
    }

    @Test
    void testlogoutPlatformManager() {
        when(mockSession.getAttribute("useremail")).thenReturn("manager@email.coms");

        ResponseEntity<?> response = entity.logout(mockSession);

        verify(mockSession).invalidate();
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Logout successful", response.getBody());
    }
}
