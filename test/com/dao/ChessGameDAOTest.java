package com.chess.dao;

import com.chess.model.GameState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ChessGameDAOTest {

    @Autowired
    private ChessGameDAO chessGameDAO;

    @Test
    void testSaveGame() {
        // Arrange
        GameState gameState = new GameState(); // Populate with test data

        // Act
        boolean isSaved = chessGameDAO.saveGame(gameState);

        // Assert
        assertTrue(isSaved);
    }

    @Test
    void testGetGameState() {
        // Arrange
        GameState gameState = new GameState(); // Populate with test data
        chessGameDAO.saveGame(gameState);

        // Act
        GameState retrievedState = chessGameDAO.getGameState();

        // Assert
        assertNotNull(retrievedState);
    }
}
