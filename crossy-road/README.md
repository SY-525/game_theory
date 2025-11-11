# Crossy Road Game

A web-based implementation of the popular Crossy Road arcade game built with HTML5 Canvas and JavaScript.

## Features

- **Classic Crossy Road Gameplay**: Navigate your chicken character across roads, rivers, and grass lanes
- **Dynamic Obstacles**:
  - 🚗 **Roads with Cars**: Avoid getting hit by cars moving in both directions at varying speeds
  - 🌊 **Rivers with Logs**: Jump on logs to cross rivers, but don't fall in the water!
  - 🌿 **Grass Lanes**: Safe zones to rest and plan your next move
- **Smooth Movement**: Animated character movement with smooth transitions
- **Procedural Generation**: Infinite gameplay with randomly generated lanes
- **Score Tracking**: Track your current score and personal best
- **Game Over Detection**: Collision detection for cars and drowning mechanics
- **Beautiful UI**: Modern, colorful design with gradient backgrounds and smooth animations

## How to Play

### Controls
- **Arrow Keys** or **WASD**: Move your chicken
  - ⬆️ **Up/W**: Move forward
  - ⬇️ **Down/S**: Move backward
  - ⬅️ **Left/A**: Move left
  - ➡️ **Right/D**: Move right

### Objective
- Navigate your chicken character across the lanes
- Avoid getting hit by cars on roads
- Jump on logs to cross rivers (don't fall in the water!)
- Move as far forward as possible to increase your score
- Try to beat your personal best!

### Game Over Conditions
- Getting hit by a car
- Falling into the water (not on a log)
- Drifting off screen while on a log

## How to Run

Simply open the `index.html` file in any modern web browser:

```bash
# Option 1: Open directly
open index.html

# Option 2: Or use a local server
python3 -m http.server 8000
# Then visit http://localhost:8000/index.html
```

No installation or dependencies required!

## Game Mechanics

### Lane Types
1. **Grass Lanes** (Green): Safe zones where you can rest
2. **Road Lanes** (Gray): Cars move at different speeds in both directions
3. **River Lanes** (Blue): You must jump on logs to cross; staying on a log moves you with it

### Scoring
- Your score increases as you move forward (upward on the screen)
- The game tracks your best score across sessions
- Challenge yourself to beat your high score!

### Tips
- Plan your moves carefully before crossing busy roads
- On rivers, time your jumps to land on logs
- Be aware that logs carry you with them - don't drift off the edge!
- Use grass lanes as safe spots to assess the situation
- The further you go, the more challenging it becomes

## Technical Details

- Built with vanilla JavaScript (no frameworks)
- HTML5 Canvas for rendering
- Smooth 60 FPS gameplay
- Responsive controls with keyboard input
- Object-oriented design with Player, Lane, and Obstacle classes
- Procedural generation system for infinite gameplay

## Browser Compatibility

Works on all modern browsers:
- Chrome/Edge (recommended)
- Firefox
- Safari
- Opera

Requires JavaScript enabled.

## Future Enhancements

Potential features for future versions:
- Multiple character skins
- Power-ups and collectibles
- Different difficulty levels
- Mobile touch controls
- Sound effects and background music
- Leaderboard system
- Additional obstacle types (trains, trucks, etc.)

## Credits

Inspired by the original Crossy Road game by Hipster Whale.

Enjoy the game! 🐔🎮
