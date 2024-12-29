package com.chess.service;

import com.chess.dao.ChessGameDAO;
import com.chess.model.GameState;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChessServiceTest {

    @InjectMocks
    private ChessService chessService;

    @Mock
    private ChessGameDAO chessGameDAO;

    public ChessServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStartNewGame() {
        // Arrange
        when(chessGameDAO.saveGame(any(GameState.class))).thenReturn(true);

        // Act
        boolean isGameStarted = chessService.startNewGame();

        // Assert
        assertTrue(isGameStarted);
        verify(chessGameDAO, times(1)).saveGame(any(GameState.class));
    }

    @Test
    void testValidateMove() {
        // Arrange
        String move = "e2e4";
        when(chessGameDAO.getGameState()).thenReturn(new GameState());

        // Act
        boolean isValid = chessService.validateMove(move);

        // Assert
        assertTrue(isValid);  // Update logic based on your implementation
        verify(chessGameDAO, times(1)).getGameState();
    }
}
