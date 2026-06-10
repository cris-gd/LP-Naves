# Space Invader

Space Invaders‑style arcade game built in Java with modular architecture, multi‑level difficulty, and dynamic enemy formations. Developed as part of the *Programming Laboratory* course at UPNA (Biomedical & Telecommunications Engineering, Spring 2024).

---

## Features

**Progressive Difficulty** — 5 levels (0–4). Enemy fire rate increases by 5% per level, starting at 10%. Points per enemy kill scale with level: 20 → 30 → 40 → 50 → 60.

**Enemy Formations** — 4 rows of 10 enemies each. Top row (highest points), middle rows (intermediate points), bottom rows (lowest points). Enemy colours are arranged symmetrically: low‑point enemies on the edges, high‑point enemies in the centre.

**Player Upgrades** — Weapon system evolves with each level:
- Level 0: 1 projectile
- Level 1: 2 projectiles
- Level 2: 3 projectiles
- Level 3: 3 projectiles (repositioned)
- Level 4: 3 homing‑style missiles with visual progression

**Health & Lives** — Visual health bar that decreases when hit by enemy lasers. 3 lives total. Game Over screen when lives reach zero.

**Explosions** — Animated 7‑frame explosion effect on enemy destruction.

**Ship Thruster Animation** — 4‑frame flame animation synchronised with ship movement.

**Dynamic Starfield** — Scrolling star background with randomised sizes and speeds.

**Real‑time Collision Detection** — Separate collision handlers for player‑to‑enemy and enemy‑to‑player interactions using bounding‑box detection.

**Multithreaded Architecture** — Dedicated helper threads for:
- Enemy movement and respawning
- Laser movement
- Starfield animation
- Score and level management
- Explosion animation
- Thruster animation
- Collision detection (player projectiles & enemy lasers)

---

## Repository Structure
```
LP-Naves/
├── src/
│ └── Principal/
│ ├── ProgramaPrincipal.java # Entry point (main)
│ ├── Ventana.java # JFrame setup
│ ├── Lienzo.java # Main JPanel with game logic
│ ├── Nave.java # Player ship
│ ├── Enemigo.java # Enemy ship with laser probability
│ ├── Shoot.java # Player projectile
│ ├── Laser.java # Enemy laser (0–4 damage types)
│ ├── Estrella.java # Background star
│ ├── Explosion.java # Explosion frame counter
│ ├── AyudanteEstrella.java # Starfield animation thread
│ ├── AyudanteShoot.java # Projectile movement thread
│ ├── AyudanteEnemigos.java # Enemy movement & respawn thread
│ ├── AyudanteLaser.java # Enemy laser movement thread
│ ├── AyudantePuntuacion.java # Score, level, health, lives thread
│ ├── AyudanteExplosion.java # Explosion animation thread
│ ├── AyudanteLlama.java # Thruster animation thread
│ ├── ColisionEnemigo.java # Projectile–enemy collision thread
│ └── ColisionNave.java # Laser–player collision thread
│ └── *png # All images related to the project 
├── .classpath # Eclipse build configuration
├── .project # Eclipse project configuration
├── .gitignore # Java‑specific ignore rules
└── README.md
```
---

## Dependencies

- **Java 9 or higher** (uses `module-info.java` with module `LP_08_Naves`)
- **Eclipse IDE** (recommended for import, but any Java IDE works)

No external libraries required — pure Java Swing and AWT.

---

## Gameplay instructions

- **Move the ship** — Drag with the mouse (the ship follows cursor position)

- **Shoot** — Press Spacebar

- **Objective** — Eliminate all enemies before they reach your ship

- **Level progression** — Every 2000 points, difficulty increases (up to level 4)

- **Health** — Each laser hit reduces health by 5–25 points depending on laser type

- **Lives** — When health reaches 0, one life is lost and health resets to 100%

---

## Technical Highlights

- **Thread safety** — Shared collections (ArrayList<Enemigo>, ArrayList<Laser>, etc.) are accessed by multiple threads; synchronisation handled via flag variables (colisionenemy, colisionnave) and thread‑local updates

- **Collision detection** — Uses bounding‑box intersection with actual image dimensions (getWidth(null) / getHeight(null))

- **Randomised enemy fire** — Math.random() with probability scaling by level: 0.1 + 0.05 * nivel

- **Level‑adaptive rendering** — paint() method switches images based on current level (ship sprites, projectile sprites, missile sprites)

---

## Authors
- **Paula Crespo**
- **Cristina García**

*Students of Biomedical & Telecommunications Engineering — Universidad Pública de Navarra (UPNA)*


