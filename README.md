# No Hybrid Otters

**[Product of Achilleus](https://linktr.ee/achilleus_)** · Maintained by [Achilleus (Achilleus-1)](https://github.com/Achilleus-1).

Prevents Hybrid Aquatic Otters from spawning naturally or during chunk generation.

## Installation

Requires **Minecraft 1.21.1**, **NeoForge**, **Java 21**, and **Hybrid Aquatic 1.7.4+**.
Build the JAR using the instructions below and place it in the Minecraft `mods` folder.
For a dedicated server, install the JAR on the server.

## Configuration

After the first launch, edit `config/no_hybrid_otters-common.toml`. Restart Minecraft or the server to apply changes.

Set `disableNaturalOtterSpawns = false` to restore natural Otter spawning. Spawn eggs, breeding, and commands still work.

## Development

Build with a Java 21 JDK using `./gradlew build` on Linux/macOS or `.\gradlew.bat build` on Windows.
The installable JAR is written to `build/libs/`. GitHub Actions builds the mod and checks the repository.

See [DEVELOPMENT.md](DEVELOPMENT.md) and [CONTRIBUTING.md](CONTRIBUTING.md).

## License

MIT. See [LICENSE](LICENSE) and [LEGAL.md](LEGAL.md).
