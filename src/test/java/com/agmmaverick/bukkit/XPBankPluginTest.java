package com.agmmaverick.bukkit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bukkit.entity.Player;
import org.junit.Test;

public class XPBankPluginTest {

    @Test
    public void testCalcXPForNextLevel() {
        assertEquals(17, XPBankPlugin.calcXPForNextLevel(0));
        assertEquals(17, XPBankPlugin.calcXPForNextLevel(15));
        assertEquals(20, XPBankPlugin.calcXPForNextLevel(16));
        assertEquals(23, XPBankPlugin.calcXPForNextLevel(17));
        assertEquals(62, XPBankPlugin.calcXPForNextLevel(30));
        assertEquals(69, XPBankPlugin.calcXPForNextLevel(31));
        
    }

    @Test
    public void testCalcTotalXPForLevel() {
        assertEquals(0, XPBankPlugin.calcTotalXPForLevel(0));
        assertEquals(17, XPBankPlugin.calcTotalXPForLevel(1));
        assertEquals(272, XPBankPlugin.calcTotalXPForLevel(16));
        assertEquals(825, XPBankPlugin.calcTotalXPForLevel(30));
        assertEquals(887, XPBankPlugin.calcTotalXPForLevel(31));
        assertEquals(956, XPBankPlugin.calcTotalXPForLevel(32));
        assertEquals(3395, XPBankPlugin.calcTotalXPForLevel(50));
    }
    
    @Test
    public void testCalcTotalXPForPlayer() {
        Player mockPlayer = mock(Player.class);
        
        setupMockPlayer(mockPlayer, 0, 0.0f);
        assertEquals(0, XPBankPlugin.calcTotalXPForPlayer(mockPlayer));
        
        setupMockPlayer(mockPlayer, 1, 0.25f);
        assertEquals(21, XPBankPlugin.calcTotalXPForPlayer(mockPlayer));
        
        setupMockPlayer(mockPlayer, 16, 0.8f);
        assertEquals(288, XPBankPlugin.calcTotalXPForPlayer(mockPlayer));
        
        setupMockPlayer(mockPlayer, 30, 0.5f);
        assertEquals(856, XPBankPlugin.calcTotalXPForPlayer(mockPlayer));
    }

    private void setupMockPlayer(Player mockPlayer, int level, float exp) {
        when(mockPlayer.getLevel()).thenReturn(level);
        when(mockPlayer.getExp()).thenReturn(exp);
    }
}
