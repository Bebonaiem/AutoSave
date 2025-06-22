# 💾 AutoSave v1.0

AutoSave is a lightweight and efficient Minecraft plugin that automatically saves world and player data at regular intervals. Designed for server administrators who want to prevent data loss without manual intervention, it works seamlessly across Minecraft versions 1.13 through 1.21.

## ✨ Key Features

### ⚡ Core Functionality
- **🌐 Multi-Version Support:** Compatible with Minecraft versions 1.13 through 1.21.
- **⏱️ Configurable Intervals:** Set your preferred save interval in seconds (default: 60s).
- **🔍 Debug Mode:** Optional debug messages to track save operations in console.
- **🔄 Reload-Safe:** Handles plugin reloads gracefully without duplicate tasks.
- **🎨 Colorful Console Output:** Features an eye-catching ASCII banner on enable.

### 🔄 Save System
- **🌍 World Data Protection:** Automatically saves all loaded worlds at regular intervals.
- **👤 Player Data Safety:** Ensures player data is saved with each cycle.
- **⚡ Efficient Operation:** Uses Bukkit's scheduler for optimal performance.

### 🛠️ Technical Features
- **📦 Lightweight:** Minimal resource usage with no external dependencies.
- **🔧 Simple Configuration:** Single config file with intuitive options.
- **📊 Verbose Logging:** Clear status messages for server administrators.

## 📥 Installation Guide

1. 🔽 Download the latest AutoSave.jar from the releases page.
2. 📂 Place the .jar file into your server's plugins/ folder.
3. 🔄 Restart your server to generate the default configuration files.
4. ⚙️ Edit plugins/AutoSave/config.yml to adjust save intervals if needed.
5. ✅ The plugin will begin working immediately with default settings.

## ⚙️ Configuration Details

```yaml
# AutoSave Configuration
# The interval in seconds between automatic saves
interval: 60

# Enable debug messages in console
debug: false
```

## 🔑 Permission Nodes

This plugin requires no special permissions as it operates automatically as a server utility.

## 🕹️ Usage Guide

### 👨‍💻 Player Interaction
No player commands are needed - the plugin works automatically in the background.

### 👨‍💼 Admin Information
The plugin starts automatically when your server loads.

To change settings:
- Edit config.yml
- Either reload the plugin or restart the server

## 🛠️ Technical Specifications

### 📦 Dependencies:
- SpigotMC API 1.13+
- No external dependencies

### ⚙️ API Support:
- Pure Bukkit/Spigot implementation

### 📊 Data Handling:
- Uses native Minecraft save methods
- No additional data storage required

### 🔧 Technical Details:
- Java 17+ required
- Built with Maven
- Minimal memory footprint

## ❓ FAQ

**Q: How often should I set the save interval?**  
A: For most servers, 60-300 seconds (1-5 minutes) is recommended. More frequent saves increase safety but may impact performance.

**Q: Does this replace regular server saves?**  
A: No, it complements them. The plugin handles periodic saves while the server still performs its own save operations.

**Q: Can I see when the plugin saves data?**  
A: Enable debug mode in the config to see save notifications in console.

**Q: Does this work with all world types?**  
A: Yes, it saves all loaded worlds including normal, nether, and end worlds.

## 🌟 Pro Tips
- For technical servers, set debug: true to monitor save operations
- Combine with regular server backups for maximum data protection
- The default 60-second interval is ideal for most survival servers

## 🤝 Support & Contributing
This plugin is maintained by Bebo. For support, please contact the developer directly.

## 📜 License
This project is licensed under the MIT License.

## 📌 Version Information
- Current Version: 1.0
- Minecraft Version: 1.13 - 1.21
- API Version: 1.13
- Java Version: 17+

## 🏗️ Building from Source
1. Clone the repository (if available)
2. Run `mvn clean package` in the project's root directory
3. Find the compiled .jar file in the target/ folder

## ⚠️ Known Limitations
- Save operations may cause brief lag spikes on very large worlds
- Interval changes require a reload/restart to take effect
- Debug messages cannot be toggled without editing config.yml

